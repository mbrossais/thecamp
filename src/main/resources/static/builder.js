try {
    console.log('builder.js');
    const RTC_URL = 'https://api.qrserver.com/v1/create-qr-code/?size=100x100&data=https://jazz-prod.centro.fr:9443/ccm/resource/itemName/com.ibm.team.workitem.WorkItem/';

    (function ($) {
        console.log('builder.js function');

        var nbPersGroup = 0,
            listeParticipant = {};



        function displayData(datas) {

            $('body').empty();
            var container = $('<div class="container"></div>');
            $('body').append(container);

            var col1 = $('<div class="col col1"></div>');
            $(container).append(col1);
            var col2 = $('<div class="col col2"></div>');
            $(container).append(col2);
            var col3 = $('<div class="col col3"></div>');
            $(container).append(col3);

            var cols = [col1, col2, col3];
            $(datas).each(function (i) {
                var indCol = i % 3;
                var col = cols[indCol];

                var objresult = $(this)[0];
                var wi = objresult.wi ? objresult.wi : '';
                var typeWi = objresult.typewi ? '<span style="color: white; background-color:' + typewiColor[objresult.typewi] + '">' + objresult.typewi + '</span>' : '';
                var classement = objresult.classement ? objresult.classement : '';
                var qrcode = objresult.qrcode ? objresult.qrcode : '';
                var libelle = objresult.libelle ? objresult.libelle : '';
                var points = objresult.points ? objresult.points : '';

                var postit = $('<div class="postit"></div>');
                $(col).append(postit);
                var tableau = $('<table></table>');
                $(postit).append(tableau);
                var tr1 = $('<tr class="line1"></tr>');
                tableau.append(tr1);
                var tr2 = $('<tr class="line2"></tr>');
                tableau.append(tr2);
                var tr3 = $('<tr class="line3"></tr>');
                tableau.append(tr3);

                tr1.append($('<td class="cellWi" colspan="2">' + typeWi + wi + '</td>'));
                tr1.append($('<td class="cellQRCode"><img class="qrcode" src="' + qrcode + '" /></td>'));

                tr2.append($('<td class="cellVersion" style="background-color:' + getCouleur(libelle) + '"></td>'));
                tr2.append($('<td class="cellLibelle" colspan="2">' + libelle + '</td>'));

                tr3.append($('<td class="cellClassement" colspan="2">' + classement + '</td>'));
                tr3.append($('<td class="cellPoints">' + points + '</td>'));

            });

        }

        function getCouleur(libelle) {
            try {
                var COLORS = {
                    DEFAULT: '#dcf441',
                    ONEDIAG: '#f441f1',
                    ONEDIFF: '#428ff4',
                };

                for (var color in COLORS) {
                    //                     console.log('libelle:' + libelle + 'LIBELLE:' + libelle.toUpperCase());
                    if (libelle.toUpperCase().includes(color)) {
                        return COLORS[color];
                    }
                }
                return COLORS.DEFAULT;

            } catch (e) {
                console.log('ERREUR lors de la récupération de la couleur')
                return '#efb26e';
            }
        }

        var $calcul = $('#calculBtn');
        var $nbPersGroup = $('#nbPersGroup');

        $calcul.on('click', function () {

            var myHeaders = new Headers({
                "Content-Type": "application/json"
            });
            //   console.log("myHEaders");
            //   console.log(myHeaders);
            var mybody = {
                nbPersGroup: parseInt($nbPersGroup.val(), 10),
                listeParticipant: listeParticipant
            };

            console.log(mybody);

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
                    console.log(json);
                    return json;
                }).catch(function (error) {
                    console.error("Posting data fail " + error.message);
                });




            // console.log(listeParticipant);
            // console.log($nbPersGroup.val());
            // console.log(
            //     {
            //         nbPersGroup: $nbPersGroup.val(),
            //         listeParticipant
            //     }
            // );
            // console.log(JSON.stringify({
            //     nbPersGroup: $nbPersGroup.val(),
            //     listeParticipant
            // }));
        });



        // $nbPersGroup.on('change', function () {
        //     console.log(listeParticipant);
        // });

        var $fileInput = $('#input');
        console.log($fileInput);

        $fileInput.on('change', function () {

            console.log('file on change');
            // Analyse des fichiers et création des prévisualisations
            var reader = new FileReader();

            reader.addEventListener('load', function () {
                // var regex = /"/gi;
                var tabRegex = /;/gi;
                //     typeWI = /Type de WI/gi,
                //     typePlanWI = /Type d'élément de travail/gi,
                //     numWI = /N° de WI/gi,
                //     ptsWI = /Points/gi,
                //     resumeWI = /Résumé/gi;
                //     classntWI = /Classement/gi;

                var result = reader.result
                    .replace(tabRegex, ',');
                // .replace(typeWI, 'type')
                // .replace(typePlanWI, 'type')
                // .replace(numWI, 'identifier')
                // .replace(ptsWI, 'points')
                // .replace(resumeWI, 'summary')
                // .replace(classntWI, 'classement')
                // .replace(regex, '');
                alert('Contenu du fichier "' + $fileInput.get(0).files[0].name + '" :\n\n' + result);
                csv({
                    output: "json"
                })
                    .fromString(result)
                    // .fromFile(csvFilePath)
                    .then((jsonObj) => {
                        console.log(jsonObj);

                        listeParticipant = jsonObj;
                    })
            });
            reader.readAsText($fileInput.get(0).files[0]);
        });


    })(jQuery);
} catch (e) {
    console.info(e);
}