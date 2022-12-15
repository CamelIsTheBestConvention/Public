const $amount = $(".charge-option-button-list");
const $option = $(".radio-label");
const $radio = $("input[name=payment-option]");
const $charge = $(".charge-button");

$amount.children().on("click", function(){
    if($(this).hasClass("selected")){
        $(this).removeClass("selected");
    } else{
        $(this).siblings().removeClass("selected");
        $(this).addClass("selected");
    }
});

$amount.children().on("click", function(){
    if($amount.children().hasClass("selected")){
        $charge.children().prop("disabled", false);//disabled 해제
    } else{
        $charge.children().prop("disabled", true);//disabled 적용
    }
});

// $option.children().on("click", function(){
//     if($amount.children().hasClass("selected") && $radio.is(":checked")){
//         $charge.children().prop("disabled", false);//disabled 해제
//     } else{
//         $charge.children().prop("disabled", true);//disabled 적용
//     }
// });

// $amount.children().on("click", function(){
//     if($amount.children().hasClass("selected") && $radio.is(":checked")){
//         $charge.children().prop("disabled", false);//disabled 해제
//     } else{
//         $charge.children().prop("disabled", true);//disabled 적용
//     }
// });