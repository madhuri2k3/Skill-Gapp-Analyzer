import React from "react";

const SkillGapCard = ({ result }) => {
  return (
    <div className="mt-8 p-6 border rounded-lg shadow-sm bg-gray-50">
      <h2 className="text-xl font-bold mb-4 text-gray-800">Results</h2>
      <div className="grid grid-cols-2 gap-6">
        <div>
          <h3 className="font-semibold text-green-700">Matched Skills</h3>
          <ul className="list-disc list-inside">
            {result.matchedSkills?.map((skill, i) => (
              <li key={i}>{skill}</li>
            ))}
          </ul>
        </div>

        <div>
          <h3 className="font-semibold text-red-700">Missing Skills</h3>
          <ul className="list-disc list-inside">
            {result.missingSkills?.map((skill, i) => (
              <li key={i}>{skill}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default SkillGapCard;
