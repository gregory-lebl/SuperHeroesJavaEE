<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SuperHeroes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="col-md-12 d-flex align-items-center justify-content-evenly h-screen vh-100 vw-100">
            <div>
                <img src="https://s.yimg.com/uu/api/res/1.2/OJh0KWvFGmVv.KxmVqa3kw--~B/aD0xMDY3O3c9MTYwMDthcHBpZD15dGFjaHlvbg--/https://o.aolcdn.com/images/dims?resize=2000%2C2000%2Cshrink&image_uri=https://s.yimg.com/os/creatr-uploaded-images/2019-04/31269e10-61da-11e9-ae75-a9c8941f54b5&client=a1acac3e1b3290917d92&signature=4a13fd81e774fd1afb2e00416a89379a0b94ddc7" alt="Illustration super héro" style="max-height: 500px;">
            </div>
            <div>
                <div class="row">
                    <h1 class="text-center mb-3">Appelez un Héro <br>ou devenez en un</h1>
                </div>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#incidentModal">Déclarer un incident</button>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#heroModal">Se référencer en tant que héro</button>
            </div>
        </div>
        <!-- Modal déclaration incident -->
        <form action="${pageContext.request.contextPath}/incident" method="post">
            <div class="modal fade" id="incidentModal" tabindex="-1" aria-labelledby="incidentModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="incidentModalLabel">Déclarer un incident</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="city" class="form-label">Ville où a lieu l'incident</label>
                                <input type="text" class="form-control" id="city" name="city" required>
                            </div>
                            <div class="mb-3 col-md-12 d-flex">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="1">
                                        <label class="form-check-label">Incendie</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="2">
                                        <label class="form-check-label">Accident routier</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="3">
                                        <label class="form-check-label">Accident fluviale</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="4">
                                        <label class="form-check-label">Accident aérien</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="5">
                                        <label class="form-check-label">Eboulement</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="6">
                                        <label class="form-check-label">Invasion de serpent</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="7">
                                        <label class="form-check-label">Fuite de gaz</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="8">
                                        <label class="form-check-label">Manifestation</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="9">
                                        <label class="form-check-label">Braquage</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="10">
                                        <label class="form-check-label">Evasion d'un prisionnier</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                            <button type="submit" class="btn btn-primary">Déclarer l'incident</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Modal déclaration héro -->
        <form action="${pageContext.request.contextPath}/hero" method="post" id="formReferenceHero">
            <div class="modal fade" id="heroModal" tabindex="-1" aria-labelledby="incidentModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="heroModalLabel">Déclarer un incident</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label class="form-label">Votre nom de super héros</label>
                                <input type="text" class="form-control" name="heroName" placeholder="LeSauveteurDuDimanche" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Coordonnées GPS de votre habitation</label>
                                <input type="text" class="form-control" name="city" placeholder="Rouen" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Votre numéro de téléphone</label>
                                <input type="text" class="form-control" name="phoneNumber" placeholder="02 56 74 95 75" required>
                            </div>
                            <div class="alert alert-danger" role="alert" id="hero-checkbox-error" style="display: none;">
                                Sélectionnez uniquement 3 incidents.
                            </div>
                            <label class="form-label">Sélectionnez 3 incidents sur lesquels vous pouvez intervenir</label>
                            <div class="mb-3 col-md-12 d-flex">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="1">
                                        <label class="form-check-label">Incendie</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="2">
                                        <label class="form-check-label">Accident routier</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="3">
                                        <label class="form-check-label">Accident fluviale</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="4">
                                        <label class="form-check-label">Accident aérien</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="5">
                                        <label class="form-check-label">Eboulement</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="6">
                                        <label class="form-check-label">Invasion de serpent</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="7">
                                        <label class="form-check-label">Fuite de gaz</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="8">
                                        <label class="form-check-label">Manifestation</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="9">
                                        <label class="form-check-label">Braquage</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" name="heroIncidents" type="checkbox" value="10">
                                        <label class="form-check-label">Evasion d'un prisionnier</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                            <button type="submit" class="btn btn-primary">S'inscrire en tant que héros</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <script>
            /**
             * Désactive un element HTML de type boutton
             * @param btn
             */
            function disabledBtn(btn) {
                btn.attr('disabled',true)
                btn.css('cursor','not-allowed')
            }
            /**
             * Active un élément HTML de type button
             * @param btn
             */
            function enableBtn(btn) {
                btn.removeAttr('disabled')
                btn.css('cursor','pointer')
            }

            /**
             * Désactivation par défaut du button
             */
            disabledBtn($("#formReferenceHero").find('button[type="submit"]'))

            $("#formReferenceHero").on('change', function () {
                let countCheckBox = $(this).find('.form-check-input:checked').length
                let submitBtn = $(this).find('button[type="submit"]')

                if (countCheckBox < 3){
                    disabledBtn(submitBtn)
                    $("#hero-checkbox-error").hide()
                }
                else if (countCheckBox > 3){
                    disabledBtn(submitBtn)
                    $("#hero-checkbox-error").show()
                }else{
                    enableBtn(submitBtn)
                    $("#hero-checkbox-error").hide()
                }
            })
        </script>
    </body>
</html>