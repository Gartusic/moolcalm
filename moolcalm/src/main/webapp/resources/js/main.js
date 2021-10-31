/**
 * 
 */

$(document).ready(function(){
	 $('#m_mainBtn')
     .click(function(){
         $(this).siblings('.m_nav').toggle("slide", { direction: "right" }, 500);
     })
});