<template>
  <div class="container">
    <div class="scroll">
      <div class="card" v-for="cabin in cabins" v-bind:key="cabin.id" @click="selectCabin(cabin)">
        <img :src="cabin.image">
        <p>{{ cabin.type }}</p>
        <p>{{ cabin.location }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import {Cabin} from "@/models/cabin";

export default {
  name: "CabinsOverview32",
  created() {
    this.lastId = 10000
    for (let i = 0; i < 8; i++) {
      this.cabins.push(
          Cabin.createSampleCabin(this.nextId())
      )
    }
  },
  data(){
    return{
      lastId: 0,
      cabins: [],
      selectedCabin: null
    }
  },
  methods: {
    nextId(){
      this.lastId = this.lastId + 3
      return this.lastId
    },
    onNewCabin(){
      this.cabins.push(Cabin.createSampleCabin(this.nextId()))
    },
    selectCabin(cabin){
      this.selectedCabin = cabin;
      console.log(this.selectedCabin)
    }

  }
}
</script>

<style scoped>
img{
  width: auto;
  height: 100px;
}

.container{
  display: flex;
  justify-content: center;
}

.scroll {
  display: flex;
  justify-content: center;
  overflow-x: scroll;

  max-width: 800px;
}

.card{
  margin-right: 20px;
}

</style>