const BASE_URL = "http://localhost:8080/api/skillgap";

export const getSkillGap = async (resumeId, jobId) => {
  try {
    const response = await fetch(`${BASE_URL}/${resumeId}/${jobId}`);
    if (!response.ok) {
      throw new Error("Failed to fetch skill gap data");
    }
    return await response.json();
  } catch (error) {
    console.error(error);
    return null;
  }
};
