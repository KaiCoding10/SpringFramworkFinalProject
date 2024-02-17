//THIS IS TO HANDLE THE FORM INPUT FOR THE HOME PAGE

const homeForm = document.querySelector("#homeForm");
const saveButton = document.querySelector("submitBtn");

saveButton.addEventListener("click", (e) => addUser(e));

window.onload = () => {
    fetch("http://localhost:8080/all")
        .then((response) => response.json())
};

const addUser = (e) => {
    e.preventDefault();
    const user = {
        fName: document.querySelector('#fName').value,
        lName: document.querySelector('#lName').value,
        id: document.querySelector('#id').value           //doesn't id auto increment?
    }

    fetch("http://localhost:8080/add", {
        method: "POST",
        headers: {"Content-Type" : "application/json"},
        body: JSON.stringify(user)
    })
    .then((response) => response.text())
    .then(() => window.location.reload());
};