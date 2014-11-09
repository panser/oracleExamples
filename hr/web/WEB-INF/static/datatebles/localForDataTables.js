$.extend( $.fn.dataTable.defaults, {
    "sPaginationType": "full_numbers"
    , "jQueryUI": true
    , stateSave: true
    , "lengthMenu": [ [10, 25, 50], [10, 25, 50] ]
//    , "lengthMenu": [ [10, 25, 50, -1 ], [10, 25, 50, "All"] ]
} );

/*
//not work ???
$(document).on('xhr.dt', function ( e, settings, json ) {
    $('#status').html( json.status );
} );
*/

function myRequest(sSource, aoData, fnCallback, oSettings) {
    oSettings.jqXHR = $.ajax({
        "dataType" : 'json',
        "cache" : 'false',
        "type" : "GET",
        "url" : sSource,
        "data" : aoData,
        "success" : function(json){
            fnCallback(json);
//            $('<div id="msg" style="display:none;"><p>This message has been added in the success callback.<br />' + json.aaData.length + ' entries have been loaded.</p></div>').insertBefore($('#departments'));
//            $('#msg').slideDown(2000);
        }
    });
}