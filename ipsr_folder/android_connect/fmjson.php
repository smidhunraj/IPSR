<?php
    // open mysql connection
    $host = "localhost";
    $username = "root";
    $password = "";
    $dbname = "employee";
    $con = mysqli_connect($host, $username, $password, $dbname) or die('Error in Connecting: ' . mysqli_error($con));

    // use prepare statement for insert query
    $st = mysqli_prepare($con, 'INSERT INTO emp(name, status,dats) VALUES (?, ?, ?)');

    // bind variables to insert query params
    mysqli_stmt_bind_param($st, 'sss', $name,  $status,$dats);
  $json = file_get_contents('php://input');
    // read json file
    //$filename = 'final.json';
   // $json = file_get_contents($filename);   

    //convert json object to php associative array
    $data = json_decode($json, true);

    // loop through the array
    foreach ($data as $row) {
        // get the employee details
        $name = $row['name'];
       
        $status = $row['status'];
        $dats=$row['dats'];
        // execute insert query
        mysqli_stmt_execute($st);
    }
    
    //close connection
    mysqli_close($con);
?>