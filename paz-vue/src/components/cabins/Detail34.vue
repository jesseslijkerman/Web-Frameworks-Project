<template>
  <h3>Cabin details (id={{this.cabinCopy.id}})</h3>
  <form>
    <label for="type">Type</label>
    <select id="type" name="type" v-model="this.cabinCopy.type">
      <option value="Beach Gear">Beach Gear</option>
      <option value="Small Day Time">Small Day Time</option>
      <option value="Small Lodge">Small Lodge</option>
      <option value="Large Lodge">Large Lodge</option>
      <option value="Family Lodge">Family Lodge</option>
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
    <input type="text" id="available" name="total-availability" v-model="this.cabinCopy.numAvailable">
  </form>
  <button @click="deleteCabin">Delete cabin</button>
  <button @click="saveCabin">Save cabin</button>
  <button @click="resetCabin">Reset cabin</button>
  <button @click="clearCabin">Clear cabin</button>
  <button @click="cancelCabin">Cancel cabin</button>

</template>

<script>
import {Cabin} from "@/models/cabin";

export default {
  name: "CabinDetail34",
  props: {
    selectedCabin: {
      type: Cabin,
      required: true
    }
  },
  emits: ["delete-cabin"],
  methods: {
    deleteCabin() {
      this.$emit("delete-cabin", this.selectedCabin.id)
      // },
      // saveCabin() {
      //
      // },
      // resetCabin() {
      //
      // },
      // clearCabin() {
      //
      // },
      // cancelCabin() {
      //
      // }
    }
  },
  data(){
    return{
      cabinCopy: null
    }
  },
  created() {
    this.cabinCopy = this.selectedCabin.copyConstructor(this.selectedCabin)
  }

}
</script>

<style scoped>
form{
  margin: auto;
  width: 80%;
}

input[type=text], select {
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