<template>
<table>
  <tr>
    <th>Type</th>
    <th>Location</th>
    <th>Description</th>
    <th>Image</th>
    <th>Price per week</th>
    <th>Number available</th>
  </tr>
  <tr v-for="cabin in cabins" v-bind:key="cabin.id">
    <td>{{ cabin.type }}</td>
    <td>{{ cabin.location }}</td>
    <td>{{ cabin.description }}</td>
    <td>
      <img :src="cabin.image">
    </td>
    <td>{{ cabin.pricePerWeek }}</td>
    <td>{{ cabin.numAvailable }}</td>
  </tr>
</table>
  <button @click="onNewCabin()">New Cabin</button>

</template>

<script>
import {Cabin} from "@/models/cabin.js";

export default {
  name: "CabinsOverview31",
  created() {
    this.lastId = 10000
    for (let i = 0; i < 8; i++) {
      this.cabins.push(
          Cabin.createSampleCabin(this.nextId())
      )
    }
    console.log(this.cabins)
  },
  data(){
    return{
      lastId: 0,
      cabins: []
    }
  },
  methods: {
    nextId(){
      this.lastId = this.lastId + 3
      return this.lastId
    },
    onNewCabin(){
      this.cabins.push(Cabin.createSampleCabin(this.nextId()))
    }
  }
}
</script>

<style scoped>
img{
  width: 200px;
  height: auto;
}

</style>