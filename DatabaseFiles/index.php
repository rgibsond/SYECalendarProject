<?php

require_once("/Users/kupps/Documents/login.php");

$db = NULL;
try {
    $db = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
} catch (PDOException $e) {
    echo "Failed Connection";
    echo "\n";
    echo $e;
    exit();
}

if ($db != NULL) {
    require_once("DatabaseUtil.php");

    /*
     * If post is set to sign up this script calls the sign up function.
     * Returns '0' if the operation was successful and '-1' if the username
     * is taken.
     */
    if (isset($_POST['SIGN_UP'])) {
        $u = $_POST['username'];
        $p = $_POST['password'];
        $result = signUp($db, $u, $p);
        echo ($result) ? '0' : '-1';
    }

    /*
     * If post[register] is set then we're adding a new account.
     * This will return '0' if the operation was successful and '-1' if the
     * sign in failed.
     */
    if (isset($_POST['SIGN_IN'])) {
        $u = $_POST['username'];
        $p = $_POST['password'];
        $result = signIn($db, $u, $p);
        echo ($result) ? '0' : '-1';
    }

}


?>
