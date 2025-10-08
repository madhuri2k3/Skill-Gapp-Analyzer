import { useState } from "react";

export default function ResumeForm({ onSubmit }) {
  const [resumeId, setResumeId] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (resumeId) onSubmit(resumeId);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Resume ID:
        <input
          type="number"
          value={resumeId}
          onChange={(e) => setResumeId(e.target.value)}
        />
      </label>
      <button type="submit">Submit Resume</button>
    </form>
  );
}
