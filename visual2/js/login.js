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
        identifiant : $("#pseudo_connexion").val(),
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
    identifiant : $("#pseudo_inscription").val()
};
    
$data3 = { 
    identifiant : $("#pseudo_inscription").val(),
    psw : $("#mot_de_passe_inscription").val()    
};

    e.preventDefault();
            var retour_requete = Requete($data2, "http://localhost:8081/register", "POST");
            console.log(retour_requete);
            if(retour_requete == 'false'){
                $("#affichage").html("<p> Ce compte existe deja</p>");   
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
                    imgurl : "URL1",
                    name : "Salamèche",
                    urlfamily : "URL2",
                    owner_id_user : sessionStorage.getItem('id')  ,
                    price : 50 
                };

                $data6 = { 
                    attack : 20,
                    defence : 120,
                    description : "Aime la laitue et le fouet",
                    energy : 70,
                    family_name : "Végétal",
                    hp : 10,
                    imgurl : "URL1",
                    name : "bulbizard",
                    urlfamily : "URL2",
                    owner_id_user : sessionStorage.getItem('id') ,
                    price :50  
                };

                $data7 = { 
                    attack : 10,
                    defence : 5,
                    description : "Tu es si faible carapuce :'(",
                    energy : 15,
                    family_name : "Eau",
                    hp : 2,
                    imgurl : "URL1",
                    name : "Carapuce",
                    urlfamily : "URL2",
                    owner_id_user : sessionStorage.getItem('id'),
                    price : 20  
                };
                Requete($data5, "http://localhost:8081/addcart" , "POST");
                Requete($data6, "http://localhost:8081/addcart" , "POST");
                Requete($data7, "http://localhost:8081/addcart" , "POST");
                
                window.location.href = "./cardHome.html";
            }
});

