<?php
header('Content-Type: application/json');
$metodo = $_SERVER['REQUEST_METHOD'];
switch ($metodo) {
    case 'GET':
        if ($_GET['accion'] == 'luchador') {
            try {
                $conexion = new PDO("mysql:host=localhost;dbname=kof", "root", "root");
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
            if (isset($_GET['id'])) {
                $pstm = $conexion->prepare('SELECT p.name, p.lastname, p.birthday, p.utiliza_magia, p.estatura, p.peso, p.equipo, m.name, l.name
            FROM personaje AS p INNER JOIN magia AS m INNER JOIN tipo_lucha AS l ON p.magia_id = m.id AND p.tipo_lucha_id = l.id AND  p.id = :n;');
                $pstm->bindParam(':n', $_GET['id']);
                $pstm->execute();
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
                if ($rs != null) {
                    echo json_encode($rs[0], JSON_PRETTY_PRINT);
                } else {
                    echo "///No se encontraron coincidencias////";
                }
            }
        }
        if ($_GET['accion'] == "todos") {
            try {
                $conexion = new PDO(
                    "mysql:host=localhost;dbname=kof;charset=utf8",
                    "root",
                    "root"
                );
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
            $pstm = $conexion->prepare('SELECT * FROM kof.personaje;');
            $pstm->execute();
            $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode($rs, JSON_PRETTY_PRINT);
        }
        if ($_GET['accion'] == "luchas") {
            try {
                $conexion = new PDO(
                    "mysql:host=localhost;dbname=kof;charset=utf8",
                    "root",
                    "root"
                );
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
            $pstm = $conexion->prepare('SELECT * FROM kof.tipo_lucha;');
            $pstm->execute();
            $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode($rs, JSON_PRETTY_PRINT);
        }
        if ($_GET['accion'] == "magia") {
            try {
                $conexion = new PDO(
                    "mysql:host=localhost;dbname=kof;charset=utf8",
                    "root",
                    "root"
                );
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
            $pstm = $conexion->prepare('SELECT * FROM kof.magia;');
            $pstm->execute();
            $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode($rs, JSON_PRETTY_PRINT);
        }
        exit();
        break;
    case 'POST':
        if ($_GET['accion'] == 'luchador') {
            $jsonData = json_decode(file_get_contents("php://input"));
            try {
                $conn = new PDO("mysql:host=localhost;dbname=kof;charset=utf8", "root", "root");
            } catch (PDOException $e) {
                echo $e->getMessage();
            }
            $query = $conn->prepare("INSERT INTO `personaje` 
            (`name`, `lastname`, `birthday`, `utiliza_magia`, `estatura`, `peso`, `equipo`, `magia_id`, `tipo_lucha_id`)
             VALUES 
             (:a, :b, :c, :d, :e, :f, :g, :h, :i);");
             $query -> bindParam(":a", $name, PDO::PARAM_STR);
             $query -> bindParam(":b", $lastname, PDO::PARAM_STR);
             $query -> bindParam(":c", $birthday, PDO::PARAM_STR);
             $query -> bindParam(":d", $utiliza_magia, PDO::PARAM_INT);
             $query -> bindParam(":e", $estatura, PDO::PARAM_INT);
             $query -> bindParam(":f", $peso, PDO::PARAM_INT);
             $query -> bindParam(":g", $equipo, PDO::PARAM_INT);
             $query -> bindParam(":h", $magia_id, PDO::PARAM_INT);
             $query -> bindParam(":i", $tipo_lucha_id, PDO::PARAM_INT);
             if ($result) {
                $_POST["error"] = false;
                $_POST["message"] = "Registrado correctamente";
                $_POST["status"] = 200;
            } else {
                $_POST["error"] = true;
                $_POST["message"] = "Error al registrar.";
                $_POST["status"] = 400;
            }
            echo json_encode($_POST);
        }
        break;
        case 'PUT':
            if ($_GET['accion'] == 'luchador') {
                $jsonData = json_decode(file_get_contents("php://input"));
                try {
                    $conn = new PDO("mysql:host=localhost;dbname=kof;charset=utf8", "root", "root");
                } catch (PDOException $e) {
                    echo $e->getMessage();
                }
                $query = $conn->prepare("UPDATE `personaje` SET `name` = :a, `lastname` = :b, `birthday` = :c, `utiliza_magia` = :d, `estatura` = :e, `peso` = :f, `equipo` = :g, `magia_id` = :h, `tipo_lucha_id` = :i WHERE (`id` = :n);");
                $query -> bindParam(":a", $name, PDO::PARAM_STR);
                $query -> bindParam(":b", $lastname, PDO::PARAM_STR);
                $query -> bindParam(":c", $birthday, PDO::PARAM_STR);
                $query -> bindParam(":d", $utiliza_magia, PDO::PARAM_INT);
                $query -> bindParam(":e", $estatura, PDO::PARAM_INT);
                $query -> bindParam(":f", $peso, PDO::PARAM_INT);
                $query -> bindParam(":g", $equipo, PDO::PARAM_INT);
                $query -> bindParam(":h", $magia_id, PDO::PARAM_INT);
                $query -> bindParam(":i", $tipo_lucha_id, PDO::PARAM_INT);
                if ($result) {
                    echo ("Personal registrado correctamente. Code $result");
                } else {
                    echo ("Error al registrar. Code $result");
                }
            }
            break;

    default:
        # code...
        break;
}
