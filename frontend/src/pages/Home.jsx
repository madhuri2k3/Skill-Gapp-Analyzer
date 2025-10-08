import React, { useState } from "react";
import UploadForm from "../components/UploadForm";
import SkillGapCard from "../components/SkillGapCard";
import Navbar from "../components/Navbar";

const Home = () => {
  const [result, setResult] = useState(null);

  const handleAnalysis = async (formData) => {
    try {
      const response = await fetch("http://localhost:8080/api/skillgap/analyze", {
        method: "POST",
        body: formData,
      });
      const data = await response.json();
      setResult(data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <Navbar />
      <div className="max-w-3xl mx-auto mt-10 p-8 bg-white rounded-2xl shadow-lg">
        <h1 className="text-3xl font-semibold text-center mb-6 text-gray-800">
          Analyze Your Skill Gap
        </h1>
        <UploadForm onAnalyze={handleAnalysis} />
        {result && <SkillGapCard result={result} />}
      </div>
    </div>
  );
};

export default Home;
