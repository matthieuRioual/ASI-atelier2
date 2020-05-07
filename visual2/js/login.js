function Requete(data, URL, method) {
    var result="";
    $.ajax({
      url:URL,
      type:method,
      contentType : "application/json",
      data :  JSON.stringify(data),
      async: false,
      success:function(data) {
         result = data; 
      }
   });
   return result;
};

$("#submit_connexion").click(function(e){

    $data1 = {
        pseudo : $("#pseudo_connexion").val(),
        psw : $("#mot_de_passe_connexion").val()
      };    

    e.preventDefault();
    var retour_requete = Requete($data1, "http://localhost:8081/connexion", "POST");
    console.log(retour_requete);
    if(retour_requete == ""){
        $("#resultat").html("<p>Votre nom ou mot de passe n'est pas reconnu : réessayez, ou inscrivez vous.</p>");
    }
    else{
            sessionStorage.setItem('name', retour_requete.name);
            sessionStorage.setItem('money', retour_requete.money);
            sessionStorage.setItem('id', retour_requete.id_user);
        
        window.location.href = "./cardHome.html";
    }
});




$("#submit_inscription").click(function(e){
    
$data2 = {
    name : $("#nom").val(),  
    psw : $("#mot_de_passe_inscription").val(),
    pseudo : $("#pseudo_inscription").val()
};
    
$data3 = { 
    pseudo : $("#pseudo_inscription").val(),
    psw : $("#mot_de_passe_inscription").val()    
};

    e.preventDefault();
            var retour_requete = Requete($data2, "http://localhost:8081/register", "POST");
            console.log(retour_requete);
            if(retour_requete == false){
                $("#resultat").html("<p> Ce pseudo est deja utilisé</p>");   
            }
            else{
                var retour_requete2 = Requete($data3, "http://localhost:8081/connexion", "POST");
                sessionStorage.setItem('name', retour_requete2.name);
                sessionStorage.setItem('money', retour_requete2.money);
                sessionStorage.setItem('id', retour_requete2.id_user);

                $data5 = { 
                    attack : 70,
                    defence : 50,
                    description : "Attention, chaud au fesse",
                    energy : 100,
                    family_name : "Feu",
                    hp : 8,
                    imgurl : "https://www.pokepedia.fr/images/8/89/Salam%C3%A8che-RFVF.png",
                    name : "Salamèche",
                    urlfamily : "https://margxt.fr/wp-content/uploads/2018/12/Pokemon-Go-Fire-80x80.png",
                    id_user : sessionStorage.getItem('id')  ,
                    price : 50 
                };

                $data6 = { 
                    attack : 20,
                    defence : 120,
                    description : "Aime la laitue et les épinards mais faites attention, il peut se montrer très puissant",
                    energy : 70,
                    family_name : "Végétal",
                    hp : 10,
                    imgurl : "https://cdn.pixabay.com/photo/2018/04/13/16/13/pixel-3316924_1280.png",
                    name : "bulbizard",
                    urlfamily : "https://margxt.fr/wp-content/uploads/2018/12/Pokemon-Go-Insecte-80x80.png",
                    id_user : sessionStorage.getItem('id') ,
                    price :50  
                };

                $data7 = { 
                    attack : 10,
                    defence : 5,
                    description : "Il se réfugie dans sa carapace et réplique en éclaboussant ses adversaires",
                    energy : 15,
                    family_name : "Eau",
                    hp : 2,
                    imgurl : "https://www.pokepedia.fr/images/3/39/Carapuce_de_Sacha.png",
                    name : "Carapuce",
                    urlfamily : "https://margxt.fr/wp-content/uploads/2018/12/Pokemon-Go-Eau-80x80.png",
                    id_user : sessionStorage.getItem('id'),
                    price : 20  
                };

                Requete($data5, "http://localhost:8081/addcard" , "POST");
                Requete($data6, "http://localhost:8081/addcard" , "POST");
                Requete($data7, "http://localhost:8081/addcard" , "POST");
                
                window.location.href = "./cardHome.html";
                console.log(sessionStorage);

            }

});

