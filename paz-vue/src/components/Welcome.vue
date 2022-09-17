<template>
  <div class="container">
  <div class="linker_kant">
    <input type="date">
    <h2>Choose a location</h2>
    <ul>
      <li>Egmond aan Zee</li>
      <li>Katwijk</li>
      <li>Renesse</li>
      <li>Zoutelandse</li>
      <li>De Panne</li>
    </ul>
  </div>
  <div class="midden">
    <h2>Photo gallery</h2>
    <div class="images">
      <img class="foto" src="@/assets/WFW_Gallerij1.jpg">
      <img class="foto" src="@/assets/WFW_Gallerij2.jpg">
      <img class="foto" src="@/assets/WFW_Gallerij3.jpg">
      <img class="foto" src="@/assets/WFW_Gallerij4.jpg">
    </div>

  </div>
  <div class="rechter_kant">
    <h2>Beach activities</h2>
    <ul class="beschrijving">
      <li>We are pleased to welcome you to Egmond aan Zee! If you want to relax for a day or for sometime, then you are
        at the right place. Egmond aan Zee is for everybody: alone, couples and families.</li>

      <li>June 3-19 May 2022</li>

      <li>Location Egmond aan Zee</li>

      <li>Price: 149 euros</li>
    </ul>
  </div>
  </div>
</template>

<script>
export default {
  name: "Welcome-item", data() {

  }

}
</script>

<style scoped>
.container{
  display:flex;
  justify-content: center;

}

.linker_kant{
  min-width: 450px;
  max-width: 450px;
  display: inline-block;
  text-align: center;
}

.midden{
  min-width: 600px;
  max-width: 600px;

}

.rechter_kant{
  min-width: 450px;
  max-width: 450px;
  display: inline-block;
  text-align: center;

}

.beschrijving li {
  padding-bottom: 30px;
}

.images{
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

.foto{
  width: 300px;
  height: auto;
  padding-bottom: 20px;
}



</style>




<!--3 kolommen -->
<!--Linker kolom fixed width -->
<!--Rechter kolom fixed width -->
<!--Middelste beweegt mee met scherm -->
<!--Linker kolom datepicker -->
<!--Linker kolom lijst locaties, aangegeven hoeveel cabins beschikbaar per geselecteerde datum -->
<!--Rechter kolom iteressante informatie special event  -->
