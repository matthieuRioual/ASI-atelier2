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

    function recuperer_cartes_user(){
        id = sessionStorage.getItem('id');
        url = "http://localhost:8081/getcard?id="+id;
        var retour_requete = Requete("", url, "GET");
        console.log(retour_requete);
        for(i=0;i<retour_requete.length;i++){
            addCardToList(retour_requete[i].urlfamily,retour_requete[i].familyName,retour_requete[i].imgurl,retour_requete[i].name,retour_requete[i].description,retour_requete[i].hp,retour_requete[i].energy,retour_requete[i].attack,retour_requete[i].defence,retour_requete[i].price,retour_requete[i].id)
        }


    }


    recuperer_cartes_user();

    function mise_en_vente(id_carte){
        
        url = "http://localhost:8081/misenvente?id="+id_carte;
        var retour_requete = Requete("", url, "GET");
        alert("Cette carte a été mise en vente");
        
    }

    function affichage_carte(id){
        url = "http://localhost:8081/getcardbyid?id="+id;
            var retour_requete = Requete("", url, "GET");
            fillCurrentCard(retour_requete.urlfamily,retour_requete.familyName,retour_requete.imgurl,retour_requete.name,retour_requete.description,retour_requete.hp,retour_requete.energy,retour_requete.attack,retour_requete.defence,retour_requete.price,retour_requete.id_card);
        };

    fillCurrentCard("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png","DC comics","http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg","SUPERMAN","The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",50,100,17,8,100);


function fillCurrentCard(imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    //FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].innerText=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].innerText=name;
    $('#cardDescriptionId')[0].innerText=description;
    $('#cardHPId')[0].innerText=hp+" HP";
    $('#cardEnergyId')[0].innerText=energy+" Energy";
    $('#cardAttackId')[0].innerText=attack+" Attack";
    $('#cardDefenceId')[0].innerText=defence+" Defence";
    $('#cardPriceId')[0].innerText=price+" $";
};


function addCardToList(imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price,id){
    console.log(typeof id);
    content="\
    <td > \
    <img  class='ui avatar image clickable' src='"+imgUrl+"'> <span>"+name+" </span> \
   </td> \
    <td >"+description+"</td> \
    <td >"+familyName+"</td> \
    <td >"+hp+"</td> \
    <td >"+energy+"</td> \
    <td >"+attack+"</td> \
    <td >"+defence+"</td> \
    <td>"+price+"$</td>\
    <td>\
        <div class='ui vertical animated button' tabindex='0'>\
            <div class='hidden content' onclick='mise_en_vente("+id+")'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>\
    ";
    
    $('#cardListId tr:last').after('<tr onclick = \"affichage_carte('+id.toString()+')\">'+content+'</tr>');
    
};


