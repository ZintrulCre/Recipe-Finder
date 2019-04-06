$(document).ready(function() {
  // on submit button click
  $('#submitBtn').on('click', function() {
    // get csv & json value
    var csvContent = $('#content-csv').val();
    var jsonContent = $('#content-json').val();

    console.log('CSV: ',csvContent);
    console.log('JSON: ', jsonContent);

    // post method
    var params = {
      csv_content: csvContent,
      json_content: jsonContent 
    }
    $.ajax({
      url: 'http://103.44.33.135/recipe-finder/query',
      type: 'POST',
      data: params
    }).done( function (response) {
      console.log(response);
      // 这里看你自己的response是返回的什么格式，赋值给result，
      // 再从result里提取出你要的结果，传到<div id="result"></div>里
      var result = response.data;
      $('#result').html(result);
    }).fail( function (response) {
      var result = 'Server Error!';
      $('#result').html(result);
      alert(result);
    })
  });
});
