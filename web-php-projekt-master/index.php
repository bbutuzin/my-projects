<?php
    session_start();
    $error = '';
    include 'PHP/db_connection.php';
    include 'PHP/db_getAdmins.php';
    include 'PHP/db_cafes.php';
    include 'PHP/db_login.php';
?>

<!-- Početak HTML-a -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web 2 Projekt</title>
    <link rel="stylesheet" href="CSS/normalize.css">
    <link rel="stylesheet" href="CSS/sidenav.css">
    <link rel="stylesheet" href="CSS/table.css">
    <link rel="stylesheet" href="CSS/navbar.css">
    <script type="text/javascript" src="JS/sidenav.js"></script>
    <script type="text/javascript" src="JS/show.js"></script>
</head>
<body>
    <!-- Lijevi navbar menu sa funkcijama za otvaranje i zatvaranje -->
    <form method="post">
        <div id="sidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <img src="Images/logoSmall.png" style="padding-left: 44px;"></img>
            <button style="background-color: transparent; border: none; color: gray; padding: 0px 8px 8px 16px; font-weight: bold; letter-spacing: 1px; font-size: 18px;" type="submit" name="viewCafes" value="true"><img src="Images/viewIcon.png" style="vertical-align:middle; padding-right: 8px">View cafés</button>
            <button style="background-color: transparent; border: none; color: gray; padding: 0px 8px 8px 16px; font-weight: bold; letter-spacing: 1px; font-size: 18px;" type="submit" name="addCafe" value="true"><img src="Images/addIcon.png" style="vertical-align:middle; padding-right: 8px">Add cafés</button>
        </div>
    </form>

    <!-- Navbar za login i otvaranje lijevog menu-a -->
    <div class="navbar">
        <span onclick="openNav()">&#9776;</span>
        <p style="color:white; position: absolute; top: 0px; left: 50px;" class="userNamePTag" id="userNamePTag"></p>
        <form method="POST"><input type="submit" name="loginBtn" value="LOGIN" class="loginBtn" id="loginBtn"></input></form>
        <img src="Images/logoNoText.png" width="42px" height="36px"></img>
    </div>

    <!-- Div u kojemu se prikazuju sve forme i tablice -->
    <div id="main">

    </div>
</body>
</html>
<!-- Kraj HTML-a -->

<?php 
    $connection = OpenConnection();
    $table = getCafes($connection);

    if(isset($_SESSION['login_user'])){
        echo '<script>document.getElementById("loginBtn").setAttribute("value","LOGOUT");</script>';
        echo '<script>document.getElementById("userNamePTag").innerHTML = "' . $_SESSION['login_user'] . '";</script>';
    }
    else if (!isset($_SESSION['login_user'])){
        echo '<script>document.getElementById("loginBtn").setAttribute("value","LOGIN");</script>';
        echo '<script>document.getElementById("userNamePTag").innerHTML = ""';
    }

    //Kada se klikne login button u navbaru.
    if(isset($_POST['loginBtn'])){
        $form = "";
        if(!isset($_SESSION['login_user'])){
            $form = getLoginForm();
            echo '<script>document.getElementById("main").innerHTML = "";</script>';
            echo '<script>document.getElementById("main").innerHTML += "' . $form . '";</script>';
        }
        else if(isset($_SESSION['login_user'])){
            $form = Logout();
            echo '<script>document.getElementById("main").innerHTML = "";</script>';
            echo "<script>alert('$form');</script>";
            echo '<script>document.getElementById("loginBtn").setAttribute("value","LOGIN")</script>';
            header("Refresh:0");
        }
    }

    //Kada se stisne login button u login formi.
    if(isset($_POST['goLogin'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        $message = Login($connection);
        echo "<script>alert('$message');</script>";
        header("Refresh:0");
    }

    //Kada se stisne view button u tablici kafica.
    if(isset($_POST['view'])){
        setcookie('index', $_POST['view'], time() + (86400 * 30), "/");
        $form = showCafe($_POST['view'], $connection);
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        echo '<script>document.getElementById("main").innerHTML += "' . $form . '";</script>';
    }

    //Kada se stisne view cafes button u lijevom sidebaru;
    if(isset($_POST['viewCafes']) || isset($_POST['search'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        echo '<script>document.getElementById("main").innerHTML += "' . $table . '";</script>';
    }

    //Kada se stisne add cafe button u lijevom sidebaru;
    if(isset($_POST['addCafe'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        $form = getCafeAddForm();
        if(isset($_SESSION['login_user'])){
            echo '<script>document.getElementById("main").innerHTML += "' . $form . '";</script>';
        }
        else{
            echo '<script>document.getElementById("main").innerHTML += "User not logged in";</script>';
        }
    }

    //Kada se stisne add button u add cafe formi.
    if(isset($_POST['addBtn'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        addCafe($connection);
        $table = getCafes($connection);
        echo '<script>document.getElementById("main").innerHTML += "' . $table . '";</script>';
    }

    //Kada se stisne edit button u tablici kafica.
    if(isset($_POST['edit'])){
        setcookie('index', $_POST['edit'], time() + (86400 * 30), "/");
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        $form = getCafeEditForm($_POST['edit'], $connection);
        if(isset($_SESSION['login_user'])){
            echo '<script>document.getElementById("main").innerHTML += "' . $form . '";</script>';
        }
        else{
            echo "<script>alert('ERROR: User not logged in.');</script>";
        }
    }

    //Kada se stisne edit button u tablici kafica.
    if(isset($_POST['editCafe'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        $form = "";
        if(isset($_COOKIE['index'])){
            $form = getCafeEditForm($_COOKIE['index'], $connection);
        }
        else{
            echo "<script>alert('ERROR: Index out of range.');</script>";
        }
        
        if(isset($_SESSION['login_user'])){
            echo '<script>document.getElementById("main").innerHTML += "' . $form . '";</script>';
        }
        else{
            echo "<script>alert('ERROR: User not logged in.');</script>";
        }
    }

    //Kada se stisne edit button u edit cafe formi.
    if(isset($_POST['editBtn'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        editCafe($_COOKIE['index'], $connection);
        $table = getCafes($connection);
        echo '<script>document.getElementById("main").innerHTML += "' . $table . '";</script>';
    }

    //Kada se stisne delete button u view cafe formi.
    if(isset($_POST['deleteCafe'])){
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        if(isset($_COOKIE['index'])){
            if(isset($_SESSION['login_user'])){
                deleteCafe($_COOKIE['index'], $connection);
            $table = getCafes($connection);
            echo '<script>document.getElementById("main").innerHTML += "' . $table . '";</script>';
            }
            else{
                echo "<script>alert('ERROR: User not logged in.');</script>";
            }
        }
        else{
            echo "<script>alert('ERROR: Index out of range.');</script>";
        }
    }

    //Kada se stisne delete button u edit formi.
    if(isset($_POST['delete'])){
        setcookie('index', $_POST['delete'], time() + (86400 * 30), "/");
        echo '<script>document.getElementById("main").innerHTML = "";</script>';
        if(isset($_SESSION['login_user'])){
            deleteCafe($_POST['delete'], $connection);
            $table = getCafes($connection);
            echo '<script>document.getElementById("main").innerHTML += "' . $table . '";</script>';
        }
        else{
            echo "<script>alert('ERROR: User not logged in.');</script>";
        }
    }
    CloseConnection($connection);
?>