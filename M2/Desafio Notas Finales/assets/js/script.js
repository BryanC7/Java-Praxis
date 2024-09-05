// Arreglo con información a mostrar en la tabla
const subjects = [
    { "ramo": "HTML", "nota_1": 0, "nota_2": 0, "nota_3": 0},
    { "ramo": "CSS", "nota_1": 0, "nota_2": 0, "nota_3": 0},
    { "ramo": "JavaScript", "nota_1": 0, "nota_2": 0, "nota_3": 0}
];

// Constantes y variables
const table = document.getElementById("table-content");

// Eventos
document.addEventListener('DOMContentLoaded', infoTable(subjects));

/**
 * Imprime la información del array subjects en la tabla
 * @param {Array} topics Arreglo con información
 */
function infoTable(topics) {
    promptValues(topics);
    topics.forEach(subject => {
        const row = document.createElement("tr");
        row.innerHTML =
        `
            <th>${subject.ramo}</th>
            <th>${subject.nota_1}</th>
            <th>${subject.nota_2}</th>
            <th>${subject.nota_3}</th>
            <th id=promedio-${subject.ramo}></th>
        `;

        table.appendChild(row);
    });
    gradesAverage();
};

/**
 * Arroja un prompt para que el usuario llene los datos del arreglo
 * @param {Array} themes Arreglo con información
 */
function promptValues(themes) {
    themes.forEach(subject => {
        for(i = 1; i <= Object.keys(subject).length - 1; i++) {
            const grades = prompt(`Ingrese nota ${i} al módulo ${subject.ramo}`);
            subject[`nota_${i}`] = parseInt(grades);
        };
    });
};


/**
 * Llama a las respectivas casillas de los promedios para buscar a sus hermanos (notas 1, 2 y 3) para retornar el valor promedio entre ellas en dichas casillas donde corresponda
 */
function gradesAverage() {
    const avgHTML = document.getElementById('promedio-HTML');
    const avgCSS = document.getElementById('promedio-CSS');
    const avgJavaScript = document.getElementById('promedio-JavaScript');

    const gradesHTML = Array.from(avgHTML.parentElement.children).splice(1, 3);
    const gradesCSS = Array.from(avgCSS.parentElement.children).splice(1, 3);
    const gradesJavaScript = Array.from(avgJavaScript.parentElement.children).splice(1, 3);

    const sumHTML = sumRow(gradesHTML); 
    const sumCSS = sumRow(gradesCSS); 
    const sumJavaScript = sumRow(gradesJavaScript);

    avgHTML.textContent = (sumHTML / gradesHTML.length).toFixed(2);
    avgCSS.textContent = (sumCSS / gradesCSS.length).toFixed(2);
    avgJavaScript.textContent = (sumJavaScript / gradesJavaScript.length).toFixed(2);
};

/**
 * Retorna el valor de la suma total de elementos dentro del arreglo
 * @param {Array} row Arreglos de los valores de las notas
 * @returns La suma de todos los elementos del arreglo
 */
function sumRow(row) {
    return row.reduce((total, cell) => total + parseFloat(cell.textContent), 0);
};