import { useState } from "react";

function App() {
  var tenlop = "CT07-Trường Đại học Hùng Vương Thành phố Hồ Chí Minh";

  // Mảng thường
  var arr = ["Việc 1", "Việc 2", "Việc 3", "Việc 4"];

  // State
  const [todoState, setTodoState] = useState([
    "Việc 1",
    "Việc 2",
    "Việc 3",
    "Việc 4",
  ]);

  // Demo sửa mảng thường
  const suaArr = () => {
    arr[1] = "Việc 2 đã sửa";
    console.log(arr);
    alert("Đã sửa arr. Giao diện KHÔNG thay đổi.");
  };

  // Demo sửa state
  const suaState = () => {
    const newTodo = [...todoState];
    newTodo[1] = "Việc 2 đã sửa";
    setTodoState(newTodo);
  };

  return (
    <div>
      <header className="App-header">
        <h1>Xin chào các bạn {tenlop}</h1>

        <button onClick={suaArr}>
          Sửa mảng arr
        </button>

        <button onClick={suaState}>
          Sửa useState
        </button>

        <h2>Mảng thường (arr)</h2>
        <table border="1">
          <thead>
            <tr>
              <th>Việc cần làm</th>
            </tr>
          </thead>
          <tbody>
            {arr.map((phantu, index) => (
              <tr key={index}>
                <td>{phantu}</td>
              </tr>
            ))}
          </tbody>
        </table>

        <h2>State (todoState)</h2>
        <table border="1">
          <thead>
            <tr>
              <th>Việc cần làm</th>
            </tr>
          </thead>
          <tbody>
            {todoState.map((phantu, index) => (
              <tr key={index}>
                <td>{phantu}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </header>
    </div>
  );
}

export default App;