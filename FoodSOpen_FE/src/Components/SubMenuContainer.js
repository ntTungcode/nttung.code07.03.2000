import { ChevronRightRounded } from "@mui/icons-material";
import React from "react";

function SubMenuContainer() {
  return (
    <div className="subMenuContianer">
      <h3>Danh Sách Món Ăn</h3>
      <div className="viewAll">
        <p>Xem Tất Cả</p>
        <i>
          <ChevronRightRounded />
        </i>
      </div>
    </div>
  );
}

export default SubMenuContainer;
