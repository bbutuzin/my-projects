<?php
    function getCafes($connection){
        if(isset($_POST['search'])){
            $query = 'SELECT ID, name, address, owner FROM cafes WHERE name LIKE \'%' . $_POST['srcName'] . '%\' AND address LIKE \'%' . $_POST['srcAddress'] . '%\' AND owner LIKE \'%' . $_POST['srcOwner'] . '%\'';
            $result = mysqli_query($connection, $query);
        }
        else{
            $query = "SELECT ID, name, address, owner FROM cafes";
            $result = mysqli_query($connection, $query);
        }
        
        $table = '<form method=\"POST\"><table><tr><th colspan=\"3\">SEARCH</th></tr>';
        $table .= '<tr><td>Name:</td><td>Address:</td><td>Owner:</td></tr>';
        $table .= '<tr><td><input type=\"text\" name=\"srcName\"></input></td><td><input type=\"text\" name=\"srcAddress\"></input></td><td><input type=\"text\" name=\"srcOwner\"></input></td></tr>';
        $table .= '<tr><td></td><td align=\"right\"><button type=\"submit\" name=\"viewCafes\" value=\"search\">RESET</button></td><td align=\"left\"><button type=\"submit\" name=\"search\" value=\"search\">SEARCH</button></td></tr>';
        $table .= '</table></form>';

        if(!isset($_SESSION['login_user'])){
            $table .= '<table><tr><th>NAME</th><th>ADDRESS</th><th>OWNER</th><th></th></tr>';

            while($row = mysqli_fetch_array($result)){
                $table .= "<tr>";
                $table .= "<td>" . $row['name'] . "</td>";
                $table .= "<td>" . $row['address'] . "</td>";
                if(is_null($row['owner'])){
                    $table .= "<td>Unknown</td>";
                }
                else{
                    $table .= "<td>" . $row['owner'] . "</td>";
                }
                $table .= '<td><form method=\"POST\"><button type=\"submit\" name=\"view\" value=\"' . $row['ID'] . '\">VIEW</button></form></td>';
                $table .= "</tr>";
            }

            $table .= "</table>";
            return $table;
        }
        if(isset($_SESSION['login_user'])){
            $table .= '<table><tr><th>NAME</th><th>ADDRESS</th><th>OWNER</th><th></th><th></th><th></th></tr>';

            while($row = mysqli_fetch_array($result)){
                $table .= "<tr>";
                $table .= "<td>" . $row['name'] . "</td>";
                $table .= "<td>" . $row['address'] . "</td>";
                if(is_null($row['owner'])){
                    $table .= "<td>Unknown</td>";
                }
                else{
                    $table .= "<td>" . $row['owner'] . "</td>";
                }
                $table .= '<td><form method=\"POST\"><button type=\"submit\" name=\"view\" value=\"' . $row['ID'] . '\">VIEW</button></form></td>';
                $table .= '<td><form method=\"POST\"><button type=\"submit\" name=\"edit\" value=\"' . $row['ID'] . '\">EDIT</button></form></td>';
                $table .= '<td><form method=\"POST\"><button type=\"submit\" name=\"delete\" value=\"' . $row['ID'] . '\">DELETE</button></form></td>';
                $table .= "</tr>";
            }

            $table .= "</table>";
            return $table;
        }
        
    }

    function showCafe($index, $connection){
        $query = "SELECT * FROM cafes WHERE ID=$index";
        $result = mysqli_query($connection, $query);

        $form = '';
        while($row = mysqli_fetch_array($result)){
            $form .= '<div style=\"width: 100%;\">';
            $form .= '<img style=\"display: block; padding: 10px; margin: auto; height: 300px; width: auto;\" src=\"' . $row['image'] . '\"></img></div>';
            $form .= '<form method=\"POST\"><table>';
            $form .= '<tr><th colspan=\"2\">' . $row['name'] . '</th></tr>';
            $form .= "<tr><td>NAME:</td><td>" . $row['name'] ."</td></tr>";
            $form .= "<tr><td>ADDRESS:</td><td>" . $row['address'] ."</td></tr>";
            $form .= "<tr><td>OWNER:</td><td>" . $row['owner'] ."</td></tr>";

            $info = '';
            $info .= ($row['coffeetogo'] == 0)? "Doesn't have coffee to go," : "Has coffee to go,";
            $info .= ($row['terrace'] == 0)? "<br>Doesn't have a terrace," : "<br>Has a terrace,";
            $info .= ($row['parking'] == 0)? "<br>Doesn't have parking," : "<br>Has parking,";
            $info .= ($row['playground'] == 0)? "<br>Doesn't have a playground." : "<br>Has a playground.";

            $form .= '<tr><td>ADDITIONAL INFORMATION:</td><td>' . $info .'</td></tr>'; 
        }
        if (isset($_SESSION['login_user'])){
            $form .= '<tr><td align=\"center\"><button type=\"submit\" name=\"deleteCafe\">DELETE</button></td><td align=\"center\"><button type=\"submit\" name=\"editCafe\">EDIT</button></td></tr>';
        }
        $form .= '</form></table>';

        return $form;
    }

    function getCafeAddForm(){
        $form = '<form method=\"POST\"><table>';
        $form .= '<tr><th colspan=\"2\">ADD CAFÉ</th></tr>';
        $form .= '<tr><td>NAME:</td><td><input type=\"text\" name=\"nameAdd\" required></input></td></tr>';
        $form .= '<tr><td>ADDRESS:</td><td><input type=\"text\" name=\"addressAdd\" required></input></td></tr>';
        $form .= '<tr><td>IMAGE LINK:</td><td><input type=\"text\" name=\"imageAdd\"></input></td></tr>';
        $form .= '<tr><td>OWNER:</td><td><input type=\"text\" name=\"ownerAdd\"></input></td></tr>';
        $form .= '<tr><td>COFFEE TO GO:</td><td><input type=\"checkbox\" value=\"true\" name=\"coffeeAdd\"></input></td></tr>';
        $form .= '<tr><td>TERRACE:</td><td><input type=\"checkbox\" value=\"true\" name=\"terraceAdd\"></input></td></tr>';
        $form .= '<tr><td>PARKING:</td><td><input type=\"checkbox\" value=\"true\" name=\"parkingAdd\"></input></td></tr>';
        $form .= '<tr><td>PLAYGROUND:</td><td><input type=\"checkbox\" value=\"true\" name=\"playgroundAdd\"></input></td></tr>';
        $form .= '<tr><td></td><td><button type=\"submit\" name=\"addBtn\">ADD</button></td></tr>';
        $form .= '</form></table>';

        return $form;
    }

    function addCafe($connection){
        if(isset($_POST['nameAdd'])){
            $name = $_POST['nameAdd'];
        }
        else{
            return;
        }

        if(isset($_POST['addressAdd'])){
            $address = $_POST['addressAdd'];
        }
        else{
            return;
        }
        
        if(isset($_POST['imageAdd'])){
            $image = $_POST['imageAdd'];
        }
        else{
            $image = '';
        }
        
        if(isset($_POST['ownerAdd'])){
            $owner = $_POST['ownerAdd'];
        }
        else{
            $owner = '';
        }
        
        if(isset($_POST['coffeeAdd'])){
            $coffee = 1;
        }
        else{
            $coffee = 0;
        }

        if(isset($_POST['terraceAdd'])){
            $terrace = 1;
        }
        else{
            $terrace = 0;
        }

        if(isset($_POST['parkingAdd'])){
            $parking = 1;
        }
        else{
            $parking = 0;
        }

        if(isset($_POST['playgroundAdd'])){
            $playground = 1;
        }
        else{
            $playground = 0;
        }

        $query = 'INSERT INTO cafes (name, address, image, owner, coffeetogo, terrace, parking, playground) VALUES ("' . $name . '" ,"' . $address . '" ,"' . $image . '" ,"' . $owner . '" ,"' . $coffee . '" ,"' . $terrace . '" ,"' . $parking . '" ,"' . $playground . '")';
        $result = mysqli_query($connection, $query);
    }

    function getCafeEditForm($index, $connection){
        $query = "SELECT * FROM cafes WHERE ID=$index";
        $result = mysqli_query($connection, $query);

        $image = '';
        $name = '';
        $address = '';
        $owner = '';
        $coffeetogo = 0;
        $terrace = 0;
        $parking = 0;
        $playground = 0;

        while($row = mysqli_fetch_array($result)){
            $image = $row['image'];
            $name = $row['name'];
            $address = $row['address'];
            $owner = $row['owner'];

            $coffeetogo = $row['coffeetogo'];
            if ($coffeetogo == 1){
                $coffeetogo = "checked";
            }
            else{
                $coffeetogo = "";
            }

            $terrace = $row['terrace'];
            if ($terrace == 1){
                $terrace = "checked";
            }
            else{
                $terrace = "";
            }

            $parking = $row['parking'];
            if ($parking == 1){
                $parking = "checked";
            }
            else{
                $parking = "";
            }

            $playground = $row['playground'];
            if ($playground == 1){
                $playground = "checked";
            }
            else{
                $playground = "";
            }

        }

        $form = '<form method=\"POST\"><table>';
        $form .= '<tr><td>NAME:</td><td><input type=\"text\" name=\"nameEdit\" value=\"' . $name . '\" required></input></td></tr>';
        $form .= '<tr><td>ADDRESS:</td><td><input type=\"text\" name=\"addressEdit\" value=\"' . $address . '\" required></input></td></tr>';
        $form .= '<tr><td>IMAGE LINK:</td><td><input type=\"text\" name=\"imageEdit\" value=\"' . $image . '\"></input></td></tr>';
        $form .= '<tr><td>OWNER:</td><td><input type=\"text\" name=\"ownerEdit\" value=\"' . $owner . '\"></input></td></tr>';
        $form .= '<tr><td>COFFEE TO GO:</td><td><input type=\"checkbox\" value=\"true\" name=\"coffeeEdit\" ' . $coffeetogo . '></input></td></tr>';
        $form .= '<tr><td>TERRACE:</td><td><input type=\"checkbox\" value=\"true\" name=\"terraceEdit\" ' . $terrace . '></input></td></tr>';
        $form .= '<tr><td>PARKING:</td><td><input type=\"checkbox\" value=\"true\" name=\"parkingEdit\" ' . $parking . '></input></td></tr>';
        $form .= '<tr><td>PLAYGROUND:</td><td><input type=\"checkbox\" value=\"true\" name=\"playgroundEdit\" ' . $playground . '></input></td></tr>';
        $form .= '<tr><td></td><td><button type=\"submit\" name=\"editBtn\">EDIT</button></td></tr>';
        $form .= '</form></table>';

        return $form;
    }

    function editCafe($index, $connection){
        if(isset($_POST['nameEdit'])){
            $name = $_POST['nameEdit'];
        }
        else{
            return;
        }

        if(isset($_POST['addressEdit'])){
            $address = $_POST['addressEdit'];
        }
        else{
            return;
        }
        
        if(isset($_POST['imageEdit'])){
            $image = $_POST['imageEdit'];
        }
        else{
            $image = '';
        }
        
        if(isset($_POST['ownerEdit'])){
            $owner = $_POST['ownerEdit'];
        }
        else{
            $owner = '';
        }
        
        if(isset($_POST['coffeeEdit'])){
            $coffeetogo = 1;
        }
        else{
            $coffeetogo = 0;
        }

        if(isset($_POST['terraceEdit'])){
            $terrace = 1;
        }
        else{
            $terrace = 0;
        }

        if(isset($_POST['parkingEdit'])){
            $parking = 1;
        }
        else{
            $parking = 0;
        }

        if(isset($_POST['playgroundEdit'])){
            $playground = 1;
        }
        else{
            $playground = 0;
        }

        $query = "UPDATE cafes SET name = '$name', address = '$address', image = '$image', owner = '$owner', coffeetogo = '$coffeetogo', terrace = '$terrace', parking = '$parking', playground = '$playground' WHERE ID = '$index';";
        $result = mysqli_query($connection, $query);
    }

    function deleteCafe($index, $connection){
        $query = "DELETE FROM cafes WHERE ID=$index";
        $result = mysqli_query($connection, $query);
    }
?>