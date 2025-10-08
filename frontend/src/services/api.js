import axios from "axios";

const BASE_URL = "http://localhost:8080/api";

export const uploadResume = async (file) => {
  const formData = new FormData();
  formData.append("file", file);
  const res = await axios.post(`${BASE_URL}/resumes/upload`, formData, {
    headers: { "Content-Type": "multipart/form-data" },
  });
  return res.data; // returns resumeId
};

export const getJobs = async () => {
  const res = await axios.get(`${BASE_URL}/jobs`);
  return res.data;
};

export const getSkillGap = async (resumeId, jobId) => {
  const res = await axios.get(`${BASE_URL}/skillgap/${resumeId}/${jobId}`);
  return res.data;
};
