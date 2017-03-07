function cerrar() {
    document.getElementById("alta").disabled = true;
    document.getElementById("baja").disabled = true;
    document.getElementById("votar").disabled = true;
    document.getElementById("censo").disabled = true;
    document.getElementById("resultado").disabled = false;
}

function compruebaDNI(dni) {
    var numero, let, letra;
    var expdni = /^[XYZ]?\d{5,8}[A-Z]$/;

    dni = dni.toUpperCase();

    if (expdni.test(dni) === true) {
        numero = dni.substr(0, dni.length - 1);
        numero = numero.replace('X', 0);
        numero = numero.replace('Y', 1);
        numero = numero.replace('Z', 2);
        let = dni.substr(dni.length - 1, 1);
        numero = numero % 23;
        letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
        letra = letra.substring(numero, numero + 1);
        if (letra !== let) {
            alert('Dni erroneo, la letra del NIF no se corresponde');
        } else {
            document.getElementById("passw").disabled = false;
        }
    } else {
        alert('Dni erroneo, formato no válido');
    }
}