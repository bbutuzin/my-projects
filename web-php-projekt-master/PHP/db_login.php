<?php
    function Login($connection){
        if (isset($_POST['goLogin'])) {    
            $username = stripslashes($_POST['username_input']);
            $password = stripslashes($_POST['password_input']);

            $sql_result = $connection->query ("SELECT * FROM administrators WHERE password = '$password' AND username='$username'");
            $rows = mysqli_num_rows($sql_result);
            if($rows == 1){
                $_SESSION['login_user'] = $username; //Initializing session
                return "Login successful.";
            } else {
                return "ERROR: Login unsuccessful. Username or password is invalid.";
            }
        }
    }

    function Logout(){
        if(isset($_SESSION['login_user'])){
            unset($_SESSION['login_user']);
            return "Successfully logged out";
        }
        return "Login unsuccessful";  
    }

    function getLoginForm(){
        $form = '<form method=\"POST\"><table>';
        $form .= '<tr><th colspan=\"2\"><center>LOGIN</center></td></tr>';
        $form .= '<tr><td>Username:</td><td><input type=\"text\" name=\"username_input\" required></input></td></tr>';
        $form .= '<tr><td>Password:</td><td><input type=\"password\" name=\"password_input\" required></input></td></tr>';
        $form .= '<tr><td></td><td colspan=\"2\"><button type=\"submit\" name=\"goLogin\" value=\"true\">LOGIN</button></td></tr>';
        $form .= '</form></table>';

        return $form;
    }
?>
    