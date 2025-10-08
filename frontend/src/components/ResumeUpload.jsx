import React from "react";

const ResumeUpload = ({ onFileSelect }) => {
  return (
    <div>
      <label>Upload Resume:</label>
      <input
        type="file"
        accept=".txt,.pdf,.docx"
        onChange={(e) => onFileSelect(e.target.files[0])}
      />
    </div>
  );
};

export default ResumeUpload;
