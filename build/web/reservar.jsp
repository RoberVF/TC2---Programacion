<%-- 
    Document   : reservar
    Created on : 02-ene-2025, 17:56:59
    Author     : rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservar Clase</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="bg-white shadow-lg rounded-lg p-8 w-96">
        <h1 class="text-2xl font-bold text-center mb-6">Reservar Clase</h1>
        <form action="/TrabajoCurso2_RobertoMoralesFumero/ReservarServlet" method="POST" class="flex flex-col gap-4">
            <div>
                <label for="nombre_cliente" class="block text-sm font-medium text-gray-700">Nombre del Cliente</label>
                <input type="text" id="nombre_cliente" name="nombre_cliente" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm" placeholder="Escribe el nombre del cliente" required>
            </div>
            <div>
                <label for="fecha_clase" class="block text-sm font-medium text-gray-700">Fecha y Hora</label>
                <input type="datetime-local" id="fecha_clase" name="fecha_clase" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm" required>
            </div>
            <div>
                <label for="tipo_clase" class="block text-sm font-medium text-gray-700">Tipo de Clase</label>
                <input type="text" id="tipo_clase" name="tipo_clase" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm"placeholder="Escribe la clase a la que asistira" required>
            </div>
            <hr>
            <button type="submit" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">Reservar</button>
            <a href="/TrabajoCurso2_RobertoMoralesFumero" class="mt-1 w-full text-center text-white py-2 px-4 rounded bg-green-500 mt-1 hover:bg-green-600">Volver</a>
        </form>
    </div>
</body>
</html>

