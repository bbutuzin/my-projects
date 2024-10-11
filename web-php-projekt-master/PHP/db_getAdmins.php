<?php
    function getAdmins($connection){
        $query = "SELECT * FROM administrators";
        $result = mysqli_query($connection, $query);

        $table = "<table><tr><th>USERNAME</th><th>PASSWORD</th></tr>";

        while($row = mysqli_fetch_array($result)){
            $table .= ("<tr><td>" . $row['username'] . "</td><td>" . $row['password'] . "</td></tr>");
        }

        $table .= "</table>";
        return $table;
    }
?>