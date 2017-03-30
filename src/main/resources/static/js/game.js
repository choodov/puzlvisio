var image;
var imageWidth;
var imageHeight;
var minPuzzleSize = 100; // in px

function getPossibleRanges(imageWidth, minPuzzleSize) {
    var rangesArray = [];
    var i = 2;
    while (i <= imageWidth/minPuzzleSize) {
        rangesArray.push(i*i);
        i++;
    }
    return rangesArray;
}


function breakImageToPieces() {
    var amountOfPiecesInRow = imageWidth/minPuzzleSize;
    console.log('amountOfPieces: ' + amountOfPiecesInRow);
}

function startGame() {
    console.log("game is started");
    breakImageToPieces();
}

function stopGame() {
    console.log("game is stopped");
}

$(document).ready(function(){
    image = $('#image');
    var range = $('#range');
    var rangespan = $('#rangespan');

    imageWidth = image.width();
    imageHeight = image.height();

    var ranges = getPossibleRanges(imageWidth, minPuzzleSize);
    rangespan.text(ranges[0]);

    range.attr('min', 0);
    range.attr('max', ranges.length-1);
    range.attr('step', 1);
    range.attr('value', 0);


    range.on('change', function() {
        var piecesId = $(this).val();
        rangespan.text(ranges[piecesId]);
    });

    $('#mainButton').click(function() {
        var mainButtonIcon = $('#mainButtonIcon');
        var buttonIcon = mainButtonIcon.text();

        switch (buttonIcon) {
            case 'play_arrow':
                mainButtonIcon.text('stop');
                startGame();
                break;
            case 'stop':
                mainButtonIcon.text('play_arrow');
                stopGame();
                break;
        }
    });

});