import React from "react";

const SkillGapResult = ({ result }) => {
  if (!result) return null;

  return (
    <div>
      <h2>Candidate: {result.candidate}</h2>
      <h2>Job: {result.jobTitle}</h2>
      <p>Match Percentage: {result.matchPercentage}%</p>
      <p>Matching Skills: {result.matchingSkills.join(", ")}</p>
      <p>Missing Skills: {result.missingSkills.join(", ")}</p>
    </div>
  );
};

export default SkillGapResult;

