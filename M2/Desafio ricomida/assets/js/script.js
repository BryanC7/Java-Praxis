const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

// Agrega un evento "click" al botón con id "enviarCorreo"
$(document).ready(function(){
    $("#enviarCorreo").click(function() {
        alert("El correo fue enviado correctamente...");
    });
});

// Agrega un evento "dblclick" a los títulos "INGREDIENTES" y "PREPARACIÓN"
$(document).ready(function() {
    $("h3").on("dblclick", function(){
        if ($(this).text() === "INGREDIENTES" || $(this).text() === "PREPARACIÓN") {
            $(this).css("color", "red");
        }
    });
});

// Agrega un evento "click" a los títulos de las tarjetas con la clase "card-title"
$(document).ready(function(){
    $(".card-title, .card-img-top").click(function(){
        var cardBody = $(this).closest(".card").find(".card-body");
        cardBody.toggle(!cardBody.is(":visible")); 
    });
});