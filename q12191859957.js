<form>
  <input type="button" value="実行" onclick="task()">
  <input type="text" id="output" size="30">
</form>
<script>
var arr = ["寒","寒寒","寒寒寒","暖","暖暖","暖暖暖","暖暖暖暖"];
var count = 0;
function task() {
  var output = document.forms[0]["output"];
  output.value = arr[(count++) % 7];
}
</script>
