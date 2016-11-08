<?php

/*
 * Returns true if the passed username and password have been inserted into the
 * database and false otherwise
 */
function signUp($db, $username, $password) {
    $users = $db->query('select username from Users');
    foreach ($users as $user) {
        if ($username == $user['username']) {
            return False;
        }
    }

    $register = $db->prepare('insert into Users(username, password) values(:username, :password);');
    $register->bindParam(':username', $username, PDO::PARAM_STR);
    $register->bindParam(':password', $password, PDO::PARAM_STR);
    return $register->execute();
}

/*
 * Returns an true if sign in was successful and false otherwise
 */
function signIn($db, $username, $password) {
    $select = $db->prepare('select username, password from Users where username=:username;');
    $select->bindParam(":username", $username, PDO::PARAM_STR);
    $select->execute();

    $user = $select->fetch(PDO::FETCH_ASSOC);

    if (isset($user) && $password == $user['password']) {
        return True;
    }

    return False;
}

?>
