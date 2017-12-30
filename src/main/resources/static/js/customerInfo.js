
var ADDRESS_PREFIX = "address-";
var CUSTOMER_PREFIX = "customer-"

var log = $("#log");
var error = $("#error");
var customerAddressForm = $("#customer-address-form");
var customerInfoForm = $("#customer-info-form");
var addressForm = $("#address-form");
var updateButtonDiv = $("#update-button-div");

var customerStruct;
var addressStruct;


$(document).ready(function(){
    $("#new-customer").click(function(){
        getCustomerStruct();
    });

    $("#search-customer").click(function(){
        $("#search-customer").html("hahaha");
    });

    refreshBlockLogic();
});



function getCustomerStruct(){
    var url = "getCustomerStruct";
    xmlHttpsGetCustomerStruct = new XMLHttpRequest();
    xmlHttpsGetCustomerStruct.onreadystatechange = function(){
        if(xmlHttpsGetCustomerStruct.readyState == 4 && xmlHttpsGetCustomerStruct.status == 200){
            var result = JSON.parse(xmlHttpsGetCustomerStruct.responseText);
            customerStruct = JSON.parse(result["returnMessage"]);
            addressStruct = JSON.parse(result["returnMessage"])["addresses"][0];
            createCustomerInfoForm();
            createAddressForm();
            createUpdateButton();

            refreshBlockLogic();
        }
    }
    xmlHttpsGetCustomerStruct.open("GET", url, true);
    xmlHttpsGetCustomerStruct.send();
}

function createCustomerInfoForm(){
    /**
     * Clear customerInfoForm
     */
    customerInfoForm.html('');

    for(var key in customerStruct){
        if(key == "addresses"){
            continue;
        }
        createInputBlock(customerInfoForm, CUSTOMER_PREFIX, key);
    }
}

function createAddressForm(){
    /**
     * Clear address form
     */
    addressForm.html("");

    for(var key in addressStruct){
        createInputBlock(addressForm, ADDRESS_PREFIX, key);
    }
}

/**
 *
 * @param form
 *          The div block to hold input block
 * @param key
 *          Key of the input block
 */
function createInputBlock(form, keyPrefix, key){
    var contextTemplate = isReadOnlyInputBlock(key) ?
        '<label for="{0}" class="col-sm-5 col-form-label">{0}</label>\n' +
        '              <div class="col-sm-7">\n' +
        '                <input type="text" readonly class="input col form-control" id="{1}" value="{2}">\n' +
        '              </div>'
        :
        '<label for="{0}" class="col-sm-5 col-form-label">{0}</label>\n' +
        '              <div class="col-sm-7">\n' +
        '                <input type="text" class="input col form-control" id="{1}" value="{2}">\n' +
        '              </div>';
    var contextSB = new StringBuilderEx();
    contextSB.appendFormat(contextTemplate, key, keyPrefix + key, "");
    form.append(contextSB);
}

function isReadOnlyInputBlock(key){
    return key == "customerId" || key == "addressId";
}

function createUpdateButton(){
    /**
     * Clear updateButtonDiv
     */
    updateButtonDiv.html("");
    var updateButtom = '<button class="col-4 btn btn-outline-primary my-2 my-sm-2" id="update-customer-address" type="submit">Update</button>';
    updateButtonDiv.append(updateButtom)
}

/**
 * Blocks logic
 */

function refreshBlockLogic(){
    refreshInputLogic();
    refreshUpdateButtonLogic();
}

function refreshInputLogic(){
    $(".input").on("input", function(){
        $("#update-customer-address").prop("disabled", false);
    });
}

function refreshUpdateButtonLogic(){
    $("#update-customer-address").click(function() {

        var address = Object.assign({}, addressStruct);
        for (var key in address) {
            address[key] = $("#" + ADDRESS_PREFIX + key).val();
        }

        var customer = Object.assign({}, customerStruct);
        for (var key in customer) {
            if (key == "addresses") {
                customer[key] = [address];
            } else {
                customer[key] = $("#" + CUSTOMER_PREFIX + key).val();
            }
        }
        log.html("Sending updated customer information: " + JSON.stringify(customer));
        updateCustomerInfo(customer);

    });
}

function updateCustomerInfo(customer) {
    var url = "/updateCustomerInfo";
    var xmlHttps = new XMLHttpRequest();
    xmlHttps.open("POST", url, true);
    xmlHttps.onreadystatechange = function() {
        if (xmlHttps.readyState == 4 && xmlHttps.status == 200) {
            var result = JSON.parse(xmlHttps.responseText);
            if(result["success"]){
                $("#update-customer-address").prop("disabled", false);
                error.html("");
                log.html("Customer infomation was updated successfully.");
            }else{
                error.html(result["errorMessage"]);
            }
        }else{
            error.html(xmlHttps.status);
        }
    }
    xmlHttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttps.send("customerJson=" + JSON.stringify(customer));
    $("#update-customer-address").prop("disabled", true);
}

