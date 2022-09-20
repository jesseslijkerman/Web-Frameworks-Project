<template>
<table>
  <tr>

  </tr>
</table>

</template>

<script>
import {Cabin} from "@/models/cabin";

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
      return this.lastId + 3;
    }
  }
}
</script>

<style scoped>

</style>