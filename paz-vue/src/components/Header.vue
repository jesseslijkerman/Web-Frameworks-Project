<template>
  <h1>Does "Header "work"?</h1>
  <div id="#app">
    <div :style="{'backgroundImage': '@/assets/Header/WFW_Noordzee_Header.jog'}"></div>
  </div>
</template>


<!--Achtergrond foto -->
<!--Logo links | Fixed grootte -->
<!--Logo Rechts | Fixed grootte-->
<!--Titel | Text wat groter dan subtitel-->
<!--Subtitel | Rechterbuitenkant van titel-->
<!-- Tussenruimte tussen titels-->
<!--Opslaan in src/assets -->


<script>
export default {
  name: "Header-item", data() {
    return {
      image: "@/assets/components/WFW_Noordzee_Header.jpg"
    }
  }
}

</script>

<style scoped>

</style>

<!--  <header-item ref="@/assets/WFW_Noordzee_Header.jpg"></header-item>-->