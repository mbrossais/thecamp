try {
    console.log('builder.js');
    const RTC_URL = 'https://api.qrserver.com/v1/create-qr-code/?size=100x100&data=https://jazz-prod.centro.fr:9443/ccm/resource/itemName/com.ibm.team.workitem.WorkItem/';

    (function ($) {
        console.log('builder.js function');

        var nbPersGroup = 0,
            listeParticipant = {};



        function displayData(datas) {
            $('.container').empty();

            var container = $('<div class="container"></div>');
            $('.container').append(container);
            
            $(datas.equipes).each(function (i) {
                var equipe = $('<div class="equipe">Equipe ' +  (i+1) + '</div>');
                $(container).append(equipe);
              
                var personnes = $('<ul class="personnes"></ul>');
                equipe.append(personnes);
                
                $(datas.equipes[i].personnes).each(function (j) {
                    var personne = datas.equipes[i].personnes[j];
                    personnes.append($('<li class="personne '+ personne.Sexe + ' ' + personne.ROLE +'">' + personne.Nom + ' ' + personne["Prénom"] + ' - ' + personne.SQUAD + ' (' + personne.Ville +')</li>'));
                });

            });

        }

        var $calcul = $('#calculBtn');
        var $nbPersGroup = $('#nbPersGroup');

        $calcul.on('click', function () {

            var myHeaders = new Headers({
                "Content-Type": "application/json"
            });

            var mybody = {
                nbPersGroup: parseInt($nbPersGroup.val(), 10),
                listeParticipant: listeParticipant
            };

            // console.log(mybody);

            var myInit = {
                method: 'POST',
                body: JSON.stringify(mybody),
                headers: myHeaders
            };



            var url = new Request('http://localhost:8080/thecamp/equipes', myInit);

            fetch(url, myInit)
                .then(function (response) {
                    if (response.ok) {
                        return response.json();
                    }
                })
                .then(function (json) {
                    // console.log(JSON.stringify(json));
                    displayData(json);
                }).catch(function (error) {
                    console.error("Posting data fail " + error.message);
                });
        });



        var $fileInput = $('#input');

        $fileInput.on('change', function () {

            // console.log('file on change');
            // Analyse des fichiers et création des prévisualisations
            var reader = new FileReader();

            reader.addEventListener('load', function () {
                // var regex = /"/gi;
                var tabRegex = /;/gi;

                var result = reader.result
                    .replace(tabRegex, ',');

                // alert('Contenu du fichier "' + $fileInput.get(0).files[0].name + '" :\n\n' + result);
                csv({
                    output: "json"
                })
                    .fromString(result)
                    // .fromFile(csvFilePath)
                    .then((jsonObj) => {
                        // console.log(jsonObj);
                        listeParticipant = jsonObj.filter(function (item) {
                            return item.Nom !== "";
                        });
                        console.log(listeParticipant);
                    })
            });
            reader.readAsText($fileInput.get(0).files[0]);
        });




        var $fileInputTest = $('#test');
        // console.log($fileInput);
        $fileInputTest.on('change', function () {
            var reader = new FileReader();
            reader.addEventListener('load', function () {
                var result = displayData(JSON.parse(reader.result));
            });
            reader.readAsText($fileInputTest.get(0).files[0]);
        });

    })(jQuery);
} catch (e) {
    console.info(e);
}