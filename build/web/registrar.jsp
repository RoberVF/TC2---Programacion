<%-- 
    Document   : registrar
    Created on : 02-ene-2025, 18:04:12
    Author     : rober
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Cliente</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="bg-white shadow-lg rounded-lg p-8 w-96">
        <h1 class="text-2xl font-bold text-center mb-6">Registrar Cliente</h1>
        <form action="/TrabajoCurso2_RobertoMoralesFumero/RegistrarServlet" method="POST" class="flex flex-col gap-4">
            <div>
                <label for="nombre" class="block text-sm font-medium text-gray-700">Nombre</label>
                <input type="text" id="nombre" name="nombre" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm" placeholder="Escribe el nombre del cliente" required>
            </div>
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700">Correo Electrónico</label>
                <input type="email" id="email" name="email" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm" placeholder="Escribe el email del cliente" required>
            </div>
            <div>
                <label for="telefono" class="block text-sm font-medium text-gray-700">Teléfono</label>
                <input type="text" id="telefono" name="telefono" class="mt-1 block bg-zinc-100 w-full p-2 rounded-lg shadow-sm" placeholder="Escribe el numero de telefono del cliente" required>
            </div>
            <hr>
            <button type="submit" class="mt-1 bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600">Registrar</button>
            <a href="/TrabajoCurso2_RobertoMoralesFumero" class="w-full text-center text-white py-2 px-4 rounded bg-green-500 mt-1 hover:bg-green-600">Volver</a>
        </form>
    </div>
</body>
</html>
