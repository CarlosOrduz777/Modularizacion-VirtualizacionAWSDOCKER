function loadRequest(){
    axios.get("/hello")
    .then(response => {
        // Obtenemos los datos
        document.getElementById("responseData").innerHTML = response;
    })
    .catch(e => {
        alert("An error ocurred");
    })

}