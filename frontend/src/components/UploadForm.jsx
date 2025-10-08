import React, { useState, useEffect } from "react";

const UploadForm = ({ onAnalyze }) => {
  const [resume, setResume] = useState(null);
  const [jobList, setJobList] = useState([]);
  const [selectedJob, setSelectedJob] = useState("");

  // Fetch available jobs from backend when the page loads
  useEffect(() => {
    const fetchJobs = async () => {
      try {
        const res = await fetch("http://localhost:8080/api/jobs");
        const data = await res.json();
        setJobList(data);
      } catch (err) {
        console.error("Error fetching jobs:", err);
      }
    };
    fetchJobs();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!resume || !selectedJob) {
      alert("Please upload a resume and select a job!");
      return;
    }
    const formData = new FormData();
    formData.append("resume", resume);
    formData.append("jobTitle", selectedJob);
    onAnalyze(formData);
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      {/* Resume Upload */}
      <div>
        <label className="block font-medium mb-2">Upload Resume</label>
        <input
          type="file"
          accept=".pdf,.docx"
          onChange={(e) => setResume(e.target.files[0])}
          className="block w-full border rounded-md px-3 py-2"
        />
      </div>

      {/* Job Dropdown */}
      <div>
        <label className="block font-medium mb-2">Select Job</label>
        <select
          value={selectedJob}
          onChange={(e) => setSelectedJob(e.target.value)}
          className="w-full border rounded-md px-3 py-2"
        >
          <option value="">-- Choose a job --</option>
          {jobList.map((job, i) => (
            <option key={i} value={job.title}>
              {job.title}
            </option>
          ))}
        </select>
      </div>

      <button
        type="submit"
        className="w-full bg-blue-600 text-white font-semibold py-2 rounded-md hover:bg-blue-700 transition"
      >
        Analyze Skill Gap
      </button>
    </form>
  );
};

export default UploadForm;
