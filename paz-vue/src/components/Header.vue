<template>
  <div class="header" :style="image">
    <div class="left-side">
      <img class="image" id="parasol" src="../assets/parasol.png">
      <div  class="date">
        <p>Today is:</p>
        <p>{{getCurrentDate()}}</p>
      </div>
    </div>
    <div class="title">
      <h1>{{siteName}}</h1>
      <h2>Come enjoy the waves!</h2>
    </div>
    <img class="image" id="zeester" src="../assets/zeester.png">
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
  name: "Header", data() {
    return {
      siteName: "Play & Stay aan Zee",
      image: "../assets/header.jpg",
      currentDate: ""
    };
  },
  methods: {
    getCurrentDate(){
      const date = new Date();
      const options = {
        dateStyle: "full",
      }
      let currentDate = date.toLocaleString("en-GB", options);
      console.log(currentDate)
      return currentDate;
    }
  }
}

</script>

<style scoped>
  .header{
    padding: 10px;
    background-image: url("../assets/header.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 200px;
    margin: 0;
    object-fit: cover;
  }

  .left-side{
    display: flex;
    justify-self: left;
  }

  .date{
    align-self: end;
    text-align: left;
  }

  .date p{
    font-size: large;
  }

  h1{
    align-self: center;
  }

  .image{
    width: auto;
    height: 150px;
  }

</style>

<!--  <header-item ref="@/assets/WFW_Noordzee_Header.jpg"></header-item>-->