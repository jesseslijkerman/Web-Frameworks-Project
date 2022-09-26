<template>
  <form>
    <label for="type">Type</label>
    <select id="type" name="type">
      <option value="beach-gear" :selected="{'selected' : selectedCabin.type === 'Beach Gear'}">Beach Gear</option>
      <option value="small-day-time" :selected="{'selected' : selectedCabin.type === 'Small Day Time'}">Small Day Time</option>
      <option value="small-lodge">Small Lodge</option>
      <option value="large-lodge">Large Lodge</option>
      <option value="Family-Lodge">Family Lodge</option>
    </select>

    <label for="location">Location</label>
    <input type="text" id="location" name="location" :value="selectedCabin.location">

    <label for="description">Description</label>
    <input type="text" id="description" name="description" :value="selectedCabin.description">

    <label for="img">Image</label>
    <input type="text" id="img" name="image" :value="selectedCabin.image">

    <label for="price">Price per week</label>
    <input type="text" id="price" name="price-per-week" :value="selectedCabin.pricePerWeek">

    <label for="available">Total availability</label>
    <input type="text" id="available" name="total-availability" :value="selectedCabin.numAvailable">
  </form>
</template>

<script>
import {Cabin} from "@/models/cabin";

export default {
  name: "CabinDetail32",
  props: {
    selectedCabin: {
      type: Cabin,
      required: true
    }
  },
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

</style>