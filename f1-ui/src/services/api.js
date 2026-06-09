import axios from "axios";

const api = axios.create({
  baseURL: "https://potential-space-waffle-p6j7xx7546vc7q4v-8080.app.github.dev/api"
});

export default api;