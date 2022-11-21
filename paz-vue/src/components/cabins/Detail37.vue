<template>
  <h3>Cabin details (id={{this.cabinCopy.id}})</h3>
  <form @submit.prevent="saveCabin">
    <label for="type">Type</label>
    <select id="type" name="type" v-model="this.cabinCopy.type">
      <option value="BeachGear">Beach Gear</option>
      <option value="SmallDayTime">Small Day Time</option>
      <option value="SmallLodge">Small Lodge</option>
      <option value="LargeLodge">Large Lodge</option>
      <option value="FamilyLodge">Family Lodge</option>
    </select>

    <label for="location">Location</label>
    <input type="text" id="location" name="location" v-model="this.cabinCopy.location">

    <label for="description">Description</label>
    <input type="text" id="description" name="description" v-model="this.cabinCopy.description">

    <label for="img">Image</label>
    <select id="img" name="image" v-model="this.cabinCopy.image">
      <option value="/img/WFW_Random0.d811a977.jpg">Image 1</option>
      <option value="/img/WFW_Random1.b4cfae01.jpg">Image 2</option>
      <option value="/img/WFW_Random2.fddc4344.jpg">Image 3</option>
      <option value="/img/WFW_Random3.631f4ca9.jpg">Image 4</option>
      <option value="/img/WFW_Random4.f1f7f6db.jpg">Image 5</option>
      <option value="/img/WFW_Random5.f52e03ea.jpg">Image 6</option>
    </select>

    <label for="price">Price per week</label>
    <input type="text" id="price" name="price-per-week" v-model="this.cabinCopy.pricePerWeek">

    <label for="available">Total availability</label>
    <input type="number" id="available" name="total-availability" v-model="this.cabinCopy.numAvailable">
    <button :disabled="hasChanged()">Save cabin</button>
  </form>
  <button @click="deleteCabin">Delete cabin</button>
  <button :disabled="hasChanged()" @click="resetCabin">Reset data</button>
  <button @click="clearCabin">Clear input</button>
  <button :disabled="hasChanged()" @click="cancelCabin">Cancel</button>

</template>

<script>
import {Cabin} from "@/models/cabin";

export default {
  name: "CabinDetail37",
  inject: ["cabinsService"],
  emits: ["delete-cabin"],
  methods: {
    deleteCabin() {
      this.cabinsService.asyncDeleteById(this.selectedCabin.id)
      this.$router.push("/overview37")
    },
    saveCabin(){
      this.cabinsService.asyncSave(JSON.stringify(this.cabinCopy))
      this.$router.push("/overview37")
    },
    resetCabin(){
      console.log(this.originalData)
      console.log(this.hasChanged())
      this.cabinCopy = Object.assign(new Cabin(0), this.originalData)
      console.log(this.cabinCopy)

    },
    clearCabin(){
      this.cabinCopy.type = ""
      this.cabinCopy.location = ""
      this.cabinCopy.description = ""
      this.cabinCopy.image = ""
      this.cabinCopy.pricePerWeek = ""
      this.cabinCopy.numAvailable = ""
    },
    cancelCabin(){
      this.$router.push("/overview37")
    },
    hasChanged(){
      return JSON.stringify(this.selectedCabin) === JSON.stringify(this.cabinCopy)
    },
    async reInitialise(){
      this.selectedCabin =
          await this.cabinsService.asyncFindById(this.$route?.params?.cabinId)
      console.log(this.$route.params?.cabinId)
      this.cabinCopy = Cabin.copyConstructor(this.selectedCabin)
    }
  },
  data(){
    return{
      cabinCopy: null,
      originalData: null,
      selectedCabin: null
    }
  },
  created() {
    this.reInitialise();
  },
  watch:{
    '$route'(){
      this.reInitialise();
    }
  }

}
</script>

<style scoped>
form{
  margin: auto;
  width: 80%;
}

input[type=text], input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label{
  float: left;
}

button{
  margin: 5px;
}

</style>