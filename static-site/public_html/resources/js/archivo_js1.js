/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
var toggle = true;

function myFunction() {
    document
            .getElementById("demo")
            .innerHTML = "Paragraph changed.";
}

function toggleElement(elementId) {
    var image = document.getElementById(elementId);
    if (toggle) {
        image.style.visibility = "hidden";
    } else {
        image.style.visibility = "visible";
    }

    toggle = !toggle;
}
