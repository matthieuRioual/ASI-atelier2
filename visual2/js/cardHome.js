$(document ).ready(function(){
    $("#playButtonId").click(function(){
        alert("Cette page n'existe pas encore");
        //TO DO
    });    
    $("#buyButtonId").click(function(){
        window.location.href = "./achat.html";
        //TO DO
    });    
    $("#sellButtonId").click(function(){
        window.location.href = "./cardList.html";
        //TO DO
    }); 
    
});

function initialisation() {
    if(typeof sessionStorage!='undefined') {
        var nom = sessionStorage.getItem('name');
        $("#userNameId").html(nom);
        var solde = sessionStorage.getItem('money');
        $("#solde").html(solde);
    }
}
