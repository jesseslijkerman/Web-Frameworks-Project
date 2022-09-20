<template>
<table>
  <tr>

  </tr>
</table>

</template>

<script>
import {Cabin} from "@/models/cabin.js";

export default {
  name: "CabinsOverview31",
  created() {
    console.log(Cabin.createSampleCabin(67));
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
      this.lastId = this.lastId + 3;
      return this.lastId
    }
  }
}
</script>

<style scoped>

</style>