<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>
<input id="${id}" name="${id}" class="input" value="${value}" />


<script>
  $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>