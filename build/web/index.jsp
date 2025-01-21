<%-- 
    Document   : index
    Created on : 02-ene-2025, 17:13:48
    Author     : Roberto Morales Fumero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gimnasio</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="relative bg-gray-100 flex items-center justify-center min-h-screen">
        <div class="bg-white shadow-lg rounded-lg p-8 w-96">
            <h1 class="text-2xl font-bold text-center mb-6 uppercase">Gimnasio</h1>
            <div class="flex flex-col gap-4">
                <a href="/TrabajoCurso2_RobertoMoralesFumero/registrar.jsp" class="bg-blue-400 text-white font-semibold text-center py-2 px-4 rounded transition duration-300 hover:scale-105 hover:bg-blue-600">
                    REGISTRAR
                </a>
                <a href="/TrabajoCurso2_RobertoMoralesFumero/reservar.jsp" class="bg-green-400 text-white font-semibold text-center py-2 px-4 rounded transition duration-300 hover:scale-105 hover:bg-green-600">
                    RESERVAR
                </a>
                <a href="/TrabajoCurso2_RobertoMoralesFumero/ConsultarServlet" class="bg-yellow-400 text-white font-semibold text-center py-2 px-4 rounded transition duration-300 hover:scale-105 hover:bg-yellow-600">
                    CONSULTAR
                </a>
            </div>
        </div>
        <div class="absolute bottom-0 right-0 px-2 py-1">
            <p class="text-xs">
                Developed by 
                <strong>Roberto Morales Fumero</strong>
            </p>
        </div>
    </body>
</html>
