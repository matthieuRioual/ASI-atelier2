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

function recuperer_cartes_vente(){
    url = "http://localhost:8081/getcard"; //URL à changer
    var retour_requete = Requete({}, url, "GET");
    for(i=0;i<length(retour_requete);i++){
        addCardToList(retour_requete[i].urlfamily,retour_requete[i].familyName,retour_requete[i].imgurl,retour_requete[i].name,retour_requete[i].description,retour_requete[i].hp,retour_requete[i].energy,retour_requete[i].attack,retour_requete[i].defence,retour_requete[i].price,retour_requete[i].id_card)
    }


}

$(document ).ready(function(){

    recuperer_cartes_vente()

});

function achat(id){
    url = "http://localhost:8081/misenvente?id=" + id; //// URL pas bonne
    var retour_requete = Requete({}, url, "GET");
    if (retour_requete == false) {
        alert("Cet achat n'a pas été réalisé")
    }
    window.location.reload();
}

function remplir_la_carte_courante(id){
    url = "http://localhost:8081/misenvente?id=" + id; //// URL pas bonne
    var retour_requete = Requete({}, url, "GET");
    fillCurrentCard(retour_requete.urlfamily,retour_requete.familyName,retour_requete.imgurl,retour_requete.name,retour_requete.description,retour_requete.hp,retour_requete.energy,retour_requete.attack,retour_requete.defence,retour_requete.price)
}






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
    
    content="\
    <td onclick = remplir_la_carte_courante(id)> \
    <img  class='ui avatar image' src='"+imgUrl+"'> <span>"+name+" </span> \
   </td> \
   <td class = 'hidden content'>"+id+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+description+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+familyName+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+hp+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+energy+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+attack+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+defence+"</td> \
    <td onclick = remplir_la_carte_courante(id)>"+price+"$</td>\
    <td>\
        <div class='ui vertical animated button' tabindex='0' onclick = achat(id)>\
            <div class='hidden content'>Buy</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";
    
    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
    
    
};